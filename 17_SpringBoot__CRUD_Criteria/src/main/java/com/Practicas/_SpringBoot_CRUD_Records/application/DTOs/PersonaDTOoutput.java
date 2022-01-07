package com.Practicas._SpringBoot_CRUD_Records.application.DTOs;

import java.util.Date;

public record PersonaDTOoutput(long id,
                               String usuario,
                               String password,
                               String name,
                               String surname,
                               String company_email,
                               String personal_email,
                               String city,
                               boolean active,
                               Date created_date,
                               String imagen_url,
                               Date termination_date) {
}

