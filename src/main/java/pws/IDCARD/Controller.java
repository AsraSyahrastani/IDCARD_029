/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.IDCARD;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ASUS
 */
public class Controller {
    @RequestMapping("/login")
    public String getLogin(@RequestParam (value="inputnama") String nama,
                           @RequestParam (value="inputdate") String date,
                           @RequestParam (value="inputfile") MultipartFile file,
                           Model model) 
            throws IOException{
        byte[] img = file.getBytes();
        String base64Image = Base64.encodeBase64String(img);
        String imglink ="data:image/png;base64,".concat(base64Image);
        model.addAttribute("Kirimnama", nama);
        model.addAttribute("Kirimdate", date);
        model.addAttribute("Kirimfile", imglink);
        return "view";
    }
}