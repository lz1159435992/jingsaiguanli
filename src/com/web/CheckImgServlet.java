package com.web;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ������֤���servlet
 */
public class CheckImgServlet extends HttpServlet {
    private static final int WIDTH = 60;//������֤��ͼƬ���
    private static final int HEIGHT = 20;//������֤��ͼƬ�߶�
    private static final int LENGTH = 4;//������֤�볤��
    //������֤��������ֵ��ַ�
    private static final String str = "1234567890" +
            "abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    char[] chars = str.toCharArray();//���ַ����������з��������ȡ
    private static Random random = new Random();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //�������������ΪͼƬ
        response.setContentType("image/jpeg");

        //���ò����л���
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache-control", "no-cache");
        response.setHeader("expires", "0");

        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_3BYTE_BGR);

        //����
        Graphics graphics = image.getGraphics();

        //���ñ�����ɫ�����ƾ��α���
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);

        //���ڼ�¼���ɵ���֤��
        String code = "";

        //������֤�벢����
        for (int i = 0; i < LENGTH; i++) {
            String c = "" + chars[random.nextInt(str.length())];
            graphics.setColor(getColor());
            graphics.drawString(c, 10 * i + 10, 18);
            code += c;
        }

        //���ɸ��ŵ�
        for (int i = 0; i < 50; i++) {
            graphics.setColor(getColor());
            graphics.drawOval(random.nextInt(60), random.nextInt(20), 1, 1);
        }

        //�����ɵ���֤�����session�У��Ա����У��
        HttpSession session = request.getSession();
        session.setAttribute("checkcode", code);

        //����ͼƬ
        graphics.dispose();

        //��ͼƬ�����response��
        ImageIO.write(image, "JPEG", response.getOutputStream());
    }

    //���������ɫ
    private Color getColor() {
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }
}