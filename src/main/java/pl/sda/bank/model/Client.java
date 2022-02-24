package pl.sda.bank.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLI_ID")
    public int id;
    @Column(name = "CLI_CLIENTID")
    public String clientId;
    @Column(name = "CLI_FIRSTNAME")
    public String firstName;
    @Column(name = "CLI_LASTNAME")
    public String lastName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLI_ADD_ID", referencedColumnName = "ADD_ID")
    public Address address;

    @OneToMany(mappedBy = "client")
    public List<Account> accountList = new ArrayList<>();

    // TODO: 23.02.2022 naprawić listę
    //Could not determine type for: java.util.List, at table: Client, for columns: [org.hibernate.mapping.Column(accountList)]

}
