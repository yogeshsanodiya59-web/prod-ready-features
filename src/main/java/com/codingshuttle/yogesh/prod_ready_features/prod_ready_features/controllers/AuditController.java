//package com.codingshuttle.yogesh.prod_ready_features.prod_ready_features.controllers;
//
//
//import com.codingshuttle.yogesh.prod_ready_features.prod_ready_features.entities.PostEntity;
//import jakarta.persistence.EntityManagerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.swing.text.html.parser.Entity;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping(path = "/audit")
//public class AuditController {
//
//    @Autowired
//    private EntityManagerFactory entityManagerFactory ;
//
////    @GetMapping(path = "/posts/{postId}")
////    List<PostEntity> getPostRevisions(@PathVariable Long postId){
////        AuditReader reader = AuditReaderFactory.get(entityManagerFactory.createEntityManager());
////
////        List<Number> revisions = reader.getRevisions(PostEntity.class, postId);
////        return revisions
////                .stream()
////                .map(revisionNumber -> reader.find(PostEntity.class , postId ,revisionNumber))
////                .collect(Collectors.toList());
//    }
//}
