package com.lujianing.test;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by lujianing on 2017/5/7.
 */
public class JavaToPdf {

    private static final String DEST = "target/HelloWorld.pdf";


    public static void main(String[] args) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(DEST));
        document.open();
        document.add(new Paragraph("hello world"));
        document.close();
        writer.close();
        System.out.println("已生成PDF文件:" + DEST);

        change();
    }

    /**
     * 将输入的PDF文件转换为图片
     *
     * @throws IOException
     */
    public static void change() throws IOException {
        String src = "target/HelloWorld_CN_HTML_FREEMARKER_FS.pdf";
        String dest = "C:\\Users\\Administrator\\Desktop";
        PDDocument doc = null;
        try {
            doc = PDDocument.load(new File(src));
            PDFRenderer render = new PDFRenderer(doc);
            int count = doc.getNumberOfPages();
            for (int i = 0; i < count; i++) {
                //设置图片的分辨率
                BufferedImage image = render.renderImageWithDPI(i, 296);
                //如果是PNG图片想要背景透明的话使用下面这个
                //BufferedImage image = render.renderImageWithDPI(i, 296, ImageType.ARGB);
                ImageIO.write(image, "PNG", new File(dest + File.separator + i + ".png"));

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (doc != null) {
                doc.close();
            }

        }
    }
}
