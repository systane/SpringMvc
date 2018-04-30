package br.com.dxc.spring.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Component
public class FileSaver {

    @Autowired
    private HttpServletRequest request;

    public String write(String baseFolder, MultipartFile file){
        try {
            String realPath = request.getServletContext().getRealPath("/" + baseFolder); //pega o path real de uma pasta no servidor
            String pathName = realPath + "/" + file.getOriginalFilename();
            file.transferTo(new File(pathName));

            return baseFolder + "/" + file.getOriginalFilename(); //caminho relativo
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


}
