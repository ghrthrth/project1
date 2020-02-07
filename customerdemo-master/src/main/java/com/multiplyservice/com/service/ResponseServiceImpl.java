package com.multiplyservice.com.service;

import com.multiplyservice.com.model.Response;
import com.multiplyservice.com.repository.ResponseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;




@Slf4j
@Service
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    ResponseRepository responseRepository;

    @Override
    public Response getById(Long id) {
        log.info("IN ResponseServiceImpl getById {}", id);
        return responseRepository.findOne(id);
    }

    @Override
    public void save(Response response) {
        log.info("IN ResponseServiceImpl save Code:{}", response);
        responseRepository.save(response);
    }

    @Override
    public void delete(Long id) {
        log.info("IN ResponseServiceImpl delete {}", id);
        responseRepository.delete(id);
    }

    @Override
    public List<Response> getAll() {
        log.info("IN ResponseServiceImpl getAll");
        return responseRepository.findAll();
    }
}
