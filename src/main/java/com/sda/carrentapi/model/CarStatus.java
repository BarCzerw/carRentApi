package com.sda.carrentapi.model;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
@Data
public class CarStatus {

    @NotNull
    private boolean isAvailable;
    @NotNull
    private boolean isRented;

}
