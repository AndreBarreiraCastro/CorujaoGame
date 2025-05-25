package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;

@ApplicationScoped
public class MinIOService {
    
    @Inject
    MinioClient minioClient;

    public void listarBuckets() {
        try {
            minioClient.listBuckets().forEach(bucket -> System.out.println(bucket.name()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     public InputStream getObject(String bucket, String objectName) throws Exception {
        return minioClient.getObject(
            GetObjectArgs.builder()
                .bucket(bucket)
                .object(objectName)
                .build()
        );
    }

      public String salvarImagem(byte[] imagem, String nomeImagem) throws IOException {
    try (InputStream input = new ByteArrayInputStream(imagem)) {
        minioClient.putObject(
            PutObjectArgs.builder()
                .bucket("dowloadimagens")
                .object(nomeImagem)
                .stream(input, imagem.length, -1)
                .contentType("application/octet-stream")
                .build()
        );
        return nomeImagem;
    } catch (Exception e) {
        e.printStackTrace(); // ← vai mostrar o erro real no terminal
        throw new IOException("Erro ao salvar no MinIO", e);
    }
}


public byte[] downloadImagem(String nomeImagem) throws IOException {
    try (InputStream inputStream = minioClient.getObject(
            GetObjectArgs.builder()
                .bucket("dowloadimagens")
                .object(nomeImagem)
                .build()
        )) {
        return inputStream.readAllBytes();
    } catch (Exception e) {
        e.printStackTrace();
        throw new IOException("Erro ao fazer download da imagem do MinIO", e);
    }
      
}
}

