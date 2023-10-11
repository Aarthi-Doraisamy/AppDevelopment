package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Card;
import com.example.entity.CardStatus;
import com.example.entity.Student;
import com.example.repositories.CardRepository;

@Service
public class CardService {


    @Autowired
    CardRepository cardRepository;


    public Card createCard(Student student){
        Card card =new Card();
        student.setCard(card);
        card.setStudent(student);
        cardRepository.save(card);
        return card;
    }
    public void deactivate(int student_id){
        cardRepository.deactivateCard(student_id, CardStatus.DEACTIVATED.toString());

    }
}
