package com.api.videosharingplatform.usecases.video;

import com.api.videosharingplatform.adapter.output.repositories.VideoRepository;
import com.api.videosharingplatform.service.exceptions.DataBaseException;
import com.api.videosharingplatform.service.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class DeleteVideoImpl implements DeleteVideo {

    private final VideoRepository videoRepository;

    public DeleteVideoImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public void deleteVideoById(Long id) {
        try {
            videoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }
}
