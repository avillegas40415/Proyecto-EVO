package com.EVO.gym.service.impl;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImgurService {

    private final String CLIENT_ID = "tu_client_id_de_imgur"; // Reemplaza con tu Client ID
    private final String UPLOAD_URL = "https://api.imgur.com/3/image";

    @Autowired
    private RestTemplate restTemplate;

    public String subirImagen(MultipartFile imagen) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Client-ID " + CLIENT_ID);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("image", Base64.getEncoder().encodeToString(imagen.getBytes()));

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                UPLOAD_URL, 
                HttpMethod.POST, 
                requestEntity, 
                String.class);

        // Procesar la respuesta de Imgur para obtener la URL de la imagen
        JSONObject jsonResponse = new JSONObject(response.getBody());
        JSONObject data = jsonResponse.getJSONObject("data");
        String urlImagen = data.getString("link");

        return urlImagen;
    }
}
