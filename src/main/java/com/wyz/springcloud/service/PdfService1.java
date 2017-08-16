package com.wyz.springcloud.service;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.TextRenderInfo;

import java.awt.geom.Rectangle2D;
import java.io.*;
import java.net.ConnectException;
import java.util.List;
import java.util.Map;

/**
 * @Author : wangyz
 * @Description :
 * @Date :  2017/7/21
 */
public class PdfService1 {

    public static void main(String[] args) throws IOException {

//        File pdfFile = new File("/Users/wyz/Desktop/债权转让通知书及还款协议20170712.pdf");
// 将word格式的文件转换为pdf格式
        // 源文件目录
        long t = System.currentTimeMillis();
//        File inputFile = new File("/Users/wyz/Downloads/temp_JKXY220170731152046020125.doc");
//        if (!inputFile.exists()) {
//            System.out.println("源文件不存在！");
//            return;
//        }
        // 输出文件目录
        String outFilePath = "/Users/wyz/Desktop/test5.pdf";
//        File outputFile = new File(outFilePath);
//        if (!outputFile.getParentFile().exists()) {
//            outputFile.getParentFile().exists();
//        }
//        // 调用openoffice服务线程
////        String command = "open /Applications/OpenOffice.app/Contents/program/soffice -headless -accept=\"socket,host=127.0.0.1,port=8100;urp;\" -nofirststartwizard";
////        Process p = Runtime.getRuntime().exec(command);
////        Runtime.getRuntime().
//        // 连接openoffice服务
//        OpenOfficeConnection connection = new SocketOpenOfficeConnection("127.0.0.1", 8100);
//        connection.connect();
//
//        // 转换word到pdf
//        DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
//        converter.convert(inputFile, outputFile);
//
//        // 关闭连接
//        connection.disconnect();
//
//        // 关闭进程
////        p.destroy();
//        InputStream is = new FileInputStream(inputFile);
//        System.out.println("文件：" + inputFile.getName() + "，大小：" + is.available() + "，转换完成！耗时：" + (System.currentTimeMillis() - t));
//        is.close();
//        InputStream out = new FileInputStream(outputFile);
//        System.out.println("pdf文件大小：" + out.available());
//        out.close();
        resu = getKeyWords(outFilePath);
        System.out.println(resu);
        if (resu != null && resu.length > 0)
            System.out.println("X=" + resu[0] + ",Y=" + resu[1] + ",page=" + resu[2]);
        System.out.println("坐标获取完成！耗时：" + (System.currentTimeMillis() - t));
    }


    // 定义关键字
    private static String KEY_WORD = "sign";
    // 定义返回值
    private static float[] resu = null;
    // 定义返回页码
    private static int i = 0;

    /*
     * 返回关键字所在的坐标和页数 float[0] >> X float[1] >> Y float[2] >> page
     */
    private static float[] getKeyWords(String filePath) {
        try {
            PdfReader pdfReader = new PdfReader(filePath);
            int pageNum = pdfReader.getNumberOfPages();

            PdfReaderContentParser pdfReaderContentParser = new PdfReaderContentParser(
                    pdfReader);

            // 下标从1开始
            for (i = 1; i < pageNum + 1; i++) {
                RenderListener renderListener = pdfReaderContentParser.processContent(i, new RenderListener() {

                    @Override
                    public void renderText(TextRenderInfo textRenderInfo) {
//                        textRenderInfo.get
                        String text = textRenderInfo.getText();
                        System.out.println("page:" + i + "。内容：" + text);
                        if (null != text && text.contains(KEY_WORD)) {
                            com.itextpdf.awt.geom.Rectangle2D.Float boundingRectange = textRenderInfo
                                    .getBaseline().getBoundingRectange();
                            resu = new float[3];
                            resu[0] = boundingRectange.x;
                            resu[1] = boundingRectange.y;
                            resu[2] = i;
                        }
                    }

                    @Override
                    public void renderImage(ImageRenderInfo arg0) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void endTextBlock() {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void beginTextBlock() {
                        // TODO Auto-generated method stub

                    }
                });
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resu;
    }

}

