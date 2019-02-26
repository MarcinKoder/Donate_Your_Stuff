package pl.mwisniewski.Donate_Your_Stuff.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "charities")
public class Charity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @Column
    private String type;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "charities_groups",
            joinColumns = @JoinColumn(name = "charity_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<SupportedGroup> groups;

    @Column(nullable = false)
    @NotNull
    private String location;

    @OneToMany(mappedBy = "charity")
    private List<Donate> donates;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Charity charity = (Charity) o;
        return Objects.equals(id, charity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Charity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<SupportedGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<SupportedGroup> groups) {
        this.groups = groups;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Donate> getDonates() {
        return donates;
    }

    public void setDonates(List<Donate> donates) {
        this.donates = donates;
    }
}
