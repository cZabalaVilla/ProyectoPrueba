package edu.fpdual.webapplication.servlet.dto;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Enumeration;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Session{
    private String userName;
    private boolean admin;
}
