package caluation;

import org.apache.log4j.Logger;

import java.math.BigDecimal;

/**
 * 计算业务类类
 */
public class Calcul {
    private static Logger log = Logger.getLogger(Calcul.class);

    public int NumberSearch(String str){
        try {
            if(str==null || str.length()==0){
                log.info("输入字符串为空！请输入有效字符串！");
                throw new Exception("输入字符串为空！请输入有效字符串！");
            }

            int count_abc=0, num_total_val=0;
            char[] chars = str.toCharArray();
            //数字之间不可连续标志
            boolean num_flag = false;
            //判断每个字符
            for(int i = 0; i < chars.length; i++){
                if((chars[i] >= 65 && chars[i] <= 90) || (chars[i] >= 97 && chars[i] <=122)){
                    count_abc++;
                    num_flag = false;
                }else if(chars[i] >= 48 && chars[i] <= 57){
                    if(num_flag == true){
                        log.info(str+":数字之间不可连续！");
                        throw new Exception(str+":数字之间不可连续！");
                    }
                    num_total_val = num_total_val + chars[i] - 48;
                    num_flag = true;
                }else{
                    num_flag = false;
                }
            }

            if(count_abc==0){
                log.info(str+":输入字符串中字母个数为空！");
                throw new Exception(str+":输入字符串中字母个数为空！");
            }

            BigDecimal count_abc_dec = new BigDecimal(count_abc);
            BigDecimal num_total_val_dec = new BigDecimal(num_total_val);
            BigDecimal result_dec = num_total_val_dec.divide(count_abc_dec,3, BigDecimal.ROUND_HALF_EVEN);
            result_dec = result_dec.setScale(0, BigDecimal.ROUND_HALF_UP);
            return result_dec.intValue();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Calcul exception:", e);
            return -1;
        }
    }

}
