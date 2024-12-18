package com.EVO.gym.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);
    
    //El BuketName es el <id_del_proyecto> + ".appspot.com#"
    final String BucketName = "techshop-90bdb.appspot.com";
    
    //Esta es la ruta basica de este proecto
    final String rutaSuperiorStorage = "techshop";
    
    //Ubicacion donde se encuentra el archivo de configuracion Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "techshop-90bdb-firebase-adminsdk-ur94h-51e1d4a4a5";
}
