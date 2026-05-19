package com.codingshuttle.yogesh.prod_ready_features.prod_ready_features.services;


import com.codingshuttle.yogesh.prod_ready_features.prod_ready_features.dto.PostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {


    List<PostDTO> getAllPosts();

    PostDTO createNewPost(PostDTO inputpost);

    PostDTO getPostById(Long postId);

    PostDTO updatePost(PostDTO inputPost, Long postId);
}
