package com.codingshuttle.yogesh.prod_ready_features.prod_ready_features.services;


import com.codingshuttle.yogesh.prod_ready_features.prod_ready_features.dto.PostDTO;
import com.codingshuttle.yogesh.prod_ready_features.prod_ready_features.entities.PostEntity;
import com.codingshuttle.yogesh.prod_ready_features.prod_ready_features.exceptions.ResourceNotFoundException;
import com.codingshuttle.yogesh.prod_ready_features.prod_ready_features.exceptions.ResourceNotFoundException;
import com.codingshuttle.yogesh.prod_ready_features.prod_ready_features.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.asm.IModelFilter;
import org.hibernate.annotations.Immutable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

//    public PostServiceImpl(PostRepository postRepository) {
//        this.postRepository = postRepository;
//    }   iski jagah lombook ka req all
//    args construtcor bhi use kar saket hai woh khud input k
//    hu=saab se dynaic consutructor form kar kr  implmnet ka rdeg a

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository
                .findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity , PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO createNewPost(PostDTO inputPost) {
        PostEntity postEntity = modelMapper.map(inputPost, PostEntity.class);
               return  modelMapper.map(postRepository.save(postEntity) , PostDTO.class);
    }

    @Override
    public PostDTO getPostById(Long postId) {
        PostEntity postEntity =postRepository
                .findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id "));

        return modelMapper.map(postEntity , PostDTO.class);
    }

    @Override
    public PostDTO updatePost(PostDTO inputPost, Long postId) {
        PostEntity olderPost= postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found with id "));
        inputPost.setId(postId);
        modelMapper.map(inputPost , olderPost);
        PostEntity savedPostEntity = postRepository.save(olderPost);
        return modelMapper.map(savedPostEntity , PostDTO.class);
    }

}
