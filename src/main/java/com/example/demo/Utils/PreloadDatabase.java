//package com.example.demo.Utils;
//
//import com.example.demo.Entity.*;
//import com.example.demo.Repository.*;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//@Configuration
//
//public class PreloadDatabase {
//    @Bean
//    CommandLineRunner initDatabase(CommentRepository commentRepository,
//                                   LikeRepository likeRepository,
//                                   PublicationRepository publicationRepository,
//                                   SubscriptionRepository subscriptionRepository,
//                                   UserRepository userRepository) {
//        return (args) -> {
//
//        };
//    }
//
//    private List<Subscription> getSubscription(List<User> users) {
//        List<Subscription> subscriptions = new ArrayList<>();
//        for (int i = 0; i < users.size(); i++) {
//            for (User user : users) {
//                if (users.get(i) != user) {
//                    subscriptions.add(Subscription.createSubscription(users.get(i), user, LocalDate.now()));
//                }
//            }
//        }
//        return subscriptions;
//    }
//
//    private List<Like> getLikes(List<User> users, List<Publication> publications) {
//        List<Like> likes = new ArrayList<>();
//        for (Publication publication : publications) {
//            for (User user : users) {
//                likes.add(Like.createLike(user, publication, LocalDate.now()));
//            }
//        }
//        return likes;
//    }
//
//    private List<Comment> getComments(List<Publication> publications, List<User> users) {
//        List<Comment> comments = new ArrayList<>();
//        for (Publication publication : publications) {
//            for (User user : users) {
//                comments.add(Comment.createComment(publication,
//                        Generator.makeDescription(), LocalDate.now(), user));
//            }
//        }
//        return comments;
//    }
//
//    private List<Publication> getPublication(List<User> users) {
//        List<Publication> publication = new ArrayList<>();
//        Random rnd = new Random();
//        for (int i = 1; i <= users.size(); i++) {
//            for (int j = 0; j < rnd.nextInt(5) + 1; j++) {
//                publication.add(Publication.createPublication("images/1pic.jpg", Generator.makeDescription(), LocalDate.now(), users.get(i - 1)));
//            }
//        }
//        return publication;
//    }
//}