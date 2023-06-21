package ma.enset.tppatient.tp2_part1springdata;

import ma.enset.tppatient.tp2_part1springdata.Entities.Patient;
import ma.enset.tppatient.tp2_part1springdata.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Tp2Part1SpringDataApplication implements CommandLineRunner {
@Autowired
private PatientRepository patientRepository;
    public static void main(String[] args) {
       SpringApplication.run(Tp2Part1SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null,"RABIY",new Date(),true,50));
        patientRepository.save(new Patient(null,"HARBALI",new Date(),true,70));
        patientRepository.save(new Patient(null,"ABBYL",new Date(),true,90));
        patientRepository.save(new Patient(null,"ETTAJI",new Date(),true,80));
        //affficher tout les patients
        System.out.println("Liste des patients");
        List<Patient> patients= patientRepository.findAll();
        patients.forEach(patient -> {
            System.out.println(patient.toString());
                });
        //afficher un patient par Id
        Patient patient=patientRepository.findById(Long.valueOf(3)).get();
        System.out.println("*************************");
        System.out.println(patient);
        //chercher des patients par mot cle
        System.out.println("**************************");
        List<Patient> patients1=patientRepository.findByNomContains("R");
        patients1.forEach(patient1 -> {
            System.out.println(patient1.toString());
        });
        //Mettre a jour un patient
        patientRepository.updatePatient(Long.valueOf(1),"Bensaid",false);
        //Supprimer un patient
        patientRepository.deleteById(Long.valueOf(2));
    }
}
