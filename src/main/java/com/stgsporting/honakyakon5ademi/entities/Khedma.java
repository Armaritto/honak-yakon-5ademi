package com.stgsporting.honakyakon5ademi.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.stgsporting.honakyakon5ademi.config.DatabaseEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = DatabaseEnum.khedmaTable)
public class Khedma extends BaseEntity {

    @Column(name = DatabaseEnum.name, nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "khedma", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<User> users;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = DatabaseEnum.baseId, referencedColumnName = DatabaseEnum.khedmaId)
    private Progress progress;

    public Integer getTodayProgress() {
        return progress.getTodayResponses();
    }

    public Integer getTotalProgress() {
        return progress.getTotalResponses();
    }
}
