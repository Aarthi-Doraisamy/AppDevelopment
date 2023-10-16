package com.auth;

import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.config.JwtService;
import com.entity.Book;
import com.entity.Feedback;
import com.entity.User;
import com.entity.enumerate.Role;
import com.repository.BookRepository;
import com.repository.FeedbackRepository;
import com.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse userregister(RegisterRequest request) {
        var user = User.builder()
        .email(request.getEmail())
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .mobile(request.getMobile())
        .Dob(request.getDob())
        .gender(request.getGender())
        .experience(request.getExperience())
        .size(request.getSize())
        .interest(request.getInterest())
        .location(request.getLocation())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.USER)
        .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
    }

    public AuthenticationResponse userauthenticate(AuthenticationRequest request) {
    	authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
       );
        var user = repository.findById(request.getEmail()).orElseThrow();
        var role = user.getRole();
        if(role.toString()=="USER") {
        	var jwtToken = jwtService.generateToken(user);
        	return AuthenticationResponse.builder().token(jwtToken).build();
        }
        else {
        	return null;
        }
    }

   public void updatedUser(String email, User updateUser){
    User user = repository.findByEmail(email);
    if(!user.toString().isEmpty()){

        user.setFirstName(updateUser.getFirstName());
        user.setLastName(updateUser.getLastName());
        user.setMobile(updateUser.getMobile());
        user.setDob(updateUser.getDob());
        user.setGender(updateUser.getGender());
        user.setExperience(updateUser.getExperience());
        user.setSize(updateUser.getSize());
        user.setInterest(updateUser.getInterest());
        user.setLocation(updateUser.getLocation());
        user.setRole(Role.USER);
        repository.save(user);
    }
   }
    public void deleteUserByUsername(String email){
        User user = repository.findByEmail(email);
        if(user!=null){
            repository.delete(user);
        }
    }
    
    public Optional<User> getuserById(String email) {
        var user = repository.findById(email);
        return user;
    }

    // Admin Service


    public AuthenticationResponse adminregister(RegisterRequest request){
        var admin =  User.builder()
        .email(request.getEmail())
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .mobile(request.getMobile())
        .Dob(request.getDob())
        .gender("Not_Available")
        .experience("Not_Available")
        .interest("Not_Available")
        .location("Not_Available")
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.ADMIN)
        .build();
        repository.save(admin);
        var jwtToken = jwtService.generateToken(admin);

        return AuthenticationResponse.builder()
        .token(jwtToken)

        .build();
    }

    public AuthenticationResponse adminAuthenticate(AuthenticationRequest request){
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        var admin = repository.findById(request.getEmail()).orElseThrow();
        var role = admin.getRole();
        if(role.toString()=="ADMIN") {
        	var adminToken = jwtService.generateToken(admin);
        	return AuthenticationResponse.builder().token(adminToken).build();
        }
        else
		 return null;
    
    }
    
    public Optional<User> getadminById(String email) {
        var admin = repository.findById(email);
        return admin;
    }

    //Plant Service
    private final BookRepository BookRepository;

    
    public String AddPlant(BookAdd request){
        var plant = Book.builder()
        .commonName(request.getCommonName())
        .description(request.getDescription())
        .bookAuthor(request.getBookAuthor())
        .bookType(request.getBookType())
        .maintenance(request.getMaintenance())
        .averageRating(request.getAverageRating())
        .bookImage(request.getBookImage())
        .build();
        BookRepository.save(plant);
        return "Plant Added Successfully";
    }

    public Optional<Book> getPlantById(long id){
        return BookRepository.findById(id);
    }

    public List<Book> getAllPlants(){
        return BookRepository.findAll();
    }

    public String updatePlant(long id, BookAdd request){
        Book Book = BookRepository.findByBookId(id);
        if(Book!=null){
        	
        	Book.setCommonName(request.getCommonName());
        	Book.setDescription(request.getDescription());
        	Book.setBookAuthor(request.getBookType());
        	Book.setBookType(request.getBookType());
        	Book.setMaintenance(request.getMaintenance());
        	Book.setAverageRating(request.getAverageRating());
        	Book.setBookImage(request.getBookImage());;
            BookRepository.save(Book);
            return "Book Updated";
        }
        return null;
    }

    public void deletePlant(long id){
        Book plant = BookRepository.findByBookId(id);
        if(plant!=null){
        	BookRepository.deleteById(id);
        }
    }
    
    //Feedback Service
    private final FeedbackRepository feedBackRepository;
    
    public String AddFeedback(Feedback request) {
    	feedBackRepository.save(request);
    	return "Feedback Added";
    }
    
    
}