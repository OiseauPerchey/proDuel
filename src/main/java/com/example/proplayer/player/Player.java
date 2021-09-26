package com.example.proplayer.player;

import javax.persistence.*;

@Entity
@Table
public class Player {

    @Id
    @SequenceGenerator(
            name = "player_sequence",
            sequenceName = "player_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "player_sequence"
    )

    private long player_id;
    private String player_name;
    private int player_pac;
    private int player_sho;
    private int player_pas;
    private int player_dri;
    private int player_def;
    private int player_phy;
    @Transient
    private int player_score;

    public Player() {
    }

    public Player(String player_name, int player_pac, int player_sho, int player_pas, int player_dri, int player_def, int player_phy) {
        this.player_name = player_name;
        this.player_pac = player_pac;
        this.player_sho = player_sho;
        this.player_pas = player_pas;
        this.player_dri = player_dri;
        this.player_def = player_def;
        this.player_phy = player_phy;
    }

    public long getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(long player_id) {
        this.player_id = player_id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public int getPlayer_pac() {
        return player_pac;
    }

    public void setPlayer_pac(int player_pac) {
        this.player_pac = player_pac;
    }

    public int getPlayer_sho() {
        return player_sho;
    }

    public void setPlayer_sho(int player_sho) {
        this.player_sho = player_sho;
    }

    public int getPlayer_pas() {
        return player_pas;
    }

    public void setPlayer_pas(int player_pas) {
        this.player_pas = player_pas;
    }

    public int getPlayer_dri() {
        return player_dri;
    }

    public void setPlayer_dri(int player_dri) {
        this.player_dri = player_dri;
    }

    public int getPlayer_def() {
        return player_def;
    }

    public void setPlayer_def(int player_def) {
        this.player_def = player_def;
    }

    public int getPlayer_phy() {
        return player_phy;
    }

    public void setPlayer_phy(int player_phy) {
        this.player_phy = player_phy;
    }

    public int getPlayer_score() {
        return (this.player_pac + this.player_sho + this.player_pas + this.player_dri + this.player_def + this.player_phy) / 6;
    }

    @Override
    public String toString() {
        return "Player{" +
                "player_id=" + player_id +
                ", player_name='" + player_name + '\'' +
                ", player_pac=" + player_pac +
                ", player_sho=" + player_sho +
                ", player_pas=" + player_pas +
                ", player_dri=" + player_dri +
                ", player_def=" + player_def +
                ", player_phy=" + player_phy +
                ", player_score=" + player_score +
                '}';
    }
}
