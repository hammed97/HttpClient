package com.example.httpclientexplore.service;

import java.io.IOException;
import java.net.URISyntaxException;

public interface PostalService {
    String getPostalDetails() throws URISyntaxException, IOException, InterruptedException;
}
