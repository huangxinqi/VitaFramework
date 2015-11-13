package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by HighProphet on 2015/9/6.
 */
public class IndexServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("doPost");
        File tempFile = new File("E:" + File.separator + "tempFile.png");
        tempFile.createNewFile();
        FileOutputStream os = new FileOutputStream(tempFile);
        InputStream is = req.getInputStream();
        byte[] buffer = new byte[1024];
        int n;
        while ((n = is.read(buffer)) != -1) {
            os.write(buffer, 0, n);
            System.out.print(new String(buffer));
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
