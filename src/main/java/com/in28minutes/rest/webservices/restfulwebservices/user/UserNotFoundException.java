package com.in28minutes.rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String id) {
        super(id);
    }


    //@AllArgsConstructor
//    public static class User {
//
//
//        private Integer id;
//        @Size(min=2, message = "Name should have atleast 2 characters")
//        @JsonProperty("user_name")
//        private String name;
//        @Past(message = "Birthdate should be in the past")
//        @JsonProperty("birth_date")
//        private LocalDate birthDate;
//
//        public User(Integer id, String name, LocalDate birthDate) {
//            this.id = id;
//            this.name = name;
//            this.birthDate = birthDate;
//        }
//
//        public Integer getId() {
//            return id;
//        }
//
//        public void setId(Integer id) {
//            this.id = id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public LocalDate getBirthDate() {
//            return birthDate;
//        }
//
//        public void setBirthDate(LocalDate birthDate) {
//            this.birthDate = birthDate;
//        }
//
//        @Override
//        public String toString() {
//            return "User{" +
//                    "id=" + id +
//                    ", name='" + name + '\'' +
//                    ", birthDate=" + birthDate +
//                    '}';
//        }
//    }
}
