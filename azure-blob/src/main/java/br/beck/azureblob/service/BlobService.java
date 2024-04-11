package br.beck.azureblob.service;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;


import com.azure.storage.blob.BlobClient;


@Service
public class BlobService {

    @Value("${sas.connection-string}")
    private String connectionString;

    @Value("${sas.container-name}")
    private String containerName;

    private BlobContainerClient containerClient() {
        BlobServiceClient serviceClient = new BlobServiceClientBuilder()
                .connectionString(connectionString).buildClient();
        BlobContainerClient container = serviceClient.getBlobContainerClient(containerName);
        return container;
    }

    public String storeFile(String filename, InputStream content, long length) {
        BlobClient client = containerClient().getBlobClient(filename);
        client.upload(content, length);
        return "File uploaded with success!";
    }
}
