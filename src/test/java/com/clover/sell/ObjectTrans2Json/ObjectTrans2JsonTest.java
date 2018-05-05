package com.clover.sell.ObjectTrans2Json;

import com.alibaba.fastjson.JSON;
import com.clover.sell.vo.ProductInfoVO;
import com.clover.sell.vo.ProductVO;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuzhentao
 * 2018/4/1 20:28
 */
public class ObjectTrans2JsonTest {

    @Test
    public void trans2JsonTest()throws IOException {
        List<ProductInfoVO> productInfoVOList = new ArrayList<>();
        ProductInfoVO productInfoVO = new ProductInfoVO();
        productInfoVO.setProductPrice(new BigDecimal(120));
        productInfoVO.setProductName("豆芽");
        productInfoVO.setProductId("233333333");
        productInfoVO.setProductIcon("http://XXXXX.jpg");
        productInfoVO.setProductDescription("很好吃啊");

        ProductInfoVO productInfoVO2 = new ProductInfoVO();
        productInfoVO2.setProductPrice(new BigDecimal(120));
        productInfoVO2.setProductName("白菜");
        productInfoVO2.setProductId("233445553");
        productInfoVO2.setProductIcon("http://XXXXX.jpg");
        productInfoVO2.setProductDescription("很好吃啊");

        ProductInfoVO productInfoVO3 = new ProductInfoVO();
        productInfoVO3.setProductPrice(new BigDecimal(120));
        productInfoVO3.setProductName("青菜");
        productInfoVO3.setProductId("233445553");
        productInfoVO3.setProductIcon("http://XXXXX.jpg");
        productInfoVO3.setProductDescription("很好吃啊");

        productInfoVOList.add(productInfoVO);
        productInfoVOList.add(productInfoVO2);
        productInfoVOList.add(productInfoVO3);

        ProductVO productVO = new ProductVO();
        productVO.setCategoryType(1);
        productVO.setCategoryName("哈哈哈");
        productVO.setProductInfos(productInfoVOList);

       // Gson gson = new Gson();
        //String json =gson.toJson(productVO);

        //String listJson = gson.toJson(productInfoVOList);

        //
       // System.out.print(json);
       // System.out.print("list 2 json:"+listJson);

        String jsonString = JSON.toJSONString(productVO);
        writeToJson("D://data.json",jsonString);
        System.out.print(jsonString);


    }

    public void writeToJson(String filePath,String object) throws IOException {
        File file = new File(filePath);
        char [] stack = new char[1024];
        int top=-1;
       // String string = object.toString();
        StringBuffer sb = new StringBuffer();
       /* char [] charArray = object.toCharArray();
        for(int i=0;i<charArray.length;i++){
            char c= charArray[i];
            if ('{' == c || '[' == c) {
                stack[++top] = c;
                sb.append("\n"+charArray[i] + "\n");
                for (int j = 0; j <= top; j++) {
                    sb.append("\t");
                }
                continue;
            }
            if ((i + 1) <= (charArray.length - 1)) {
                char d = charArray[i+1];
                if ('}' == d || ']' == d) {
                    top--;
                    sb.append(charArray[i] + "\n");
                    for (int j = 0; j <= top; j++) {
                        sb.append("\t");
                    }
                    continue;
                }
            }
            if (',' == c) {
                sb.append(charArray[i] + "");
                for (int j = 0; j <= top; j++) {
                    sb.append("");
                }
                continue;
            }
            sb.append(c);
        }*/
        Writer write = new FileWriter(file);
                write.write(object);
        write.flush();
        write.close();
    }

}
