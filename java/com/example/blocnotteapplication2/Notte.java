package com.example.blocnotteapplication2;

public class Notte {
    private String nottes;
    private String dattes;
    private String heure;

    public Notte() {
    }

    public Notte(String nottes, String dattes, String heure) {
        this.nottes = nottes;
        this.dattes = dattes;
        this.heure = heure;
    }

    public String getNottes() {
        return nottes;
    }

    public void setNottes(String nottes) {
        this.nottes = nottes;
    }

    public String getDattes() {
        return dattes;
    }

    public void setDattes(String dattes) {
        this.dattes = dattes;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }
}
