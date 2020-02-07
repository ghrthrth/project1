package com.multiplyservice.com.service;

import com.multiplyservice.com.model.Response;

import java.util.List;



public interface ResponseService {

    Response getById(Long id);

    void save(Response response);

    void delete(Long id);

    List<Response> getAll();
}
