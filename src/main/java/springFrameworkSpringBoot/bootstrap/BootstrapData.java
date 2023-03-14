package springFrameworkSpringBoot.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springFrameworkSpringBoot.domain.Author;
import springFrameworkSpringBoot.domain.Book;
import springFrameworkSpringBoot.repositories.AuthorRepository;
import springFrameworkSpringBoot.repositories.BookRepository;

/**
 * @Created 14  03 2023 - 11:06 AM
 * @Author Hazeem Hassan
 */

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        saveAndDisplayData();

    }

    private void saveAndDisplayData() {
        //saving data
        Author sirSyedAhmadKhan = new Author();
        sirSyedAhmadKhan.setFirstName("Sir Syed ");
        sirSyedAhmadKhan.setLastName("Ahmad Khan");

        Author sirSyedAhmadKhanSaved = authorRepository.save(sirSyedAhmadKhan);

        Book tefseerUlQuran = new Book();
        tefseerUlQuran.setTitle("TAFSEER - UL - QURAN");
        tefseerUlQuran.setIsbn("1877-1362");

        Book aakiriMazameen = new Book();
        aakiriMazameen.setTitle("AAKHIRI MAZAMEEN");
        aakiriMazameen.setIsbn("1898-187");

        Book khutbatEAhmadiya = new Book();
        khutbatEAhmadiya.setTitle("KHUTBAT - E - AHMADIYA");
        khutbatEAhmadiya.setIsbn("1870-696");

        Book khutootESirSyed = new Book();
        khutootESirSyed.setTitle("KHUTOOT - E - SIR SYED");
        khutootESirSyed.setIsbn("1931-67");

        Book lectur = new Book();
        lectur.setTitle("LECTUR");
        lectur.setIsbn(" 1889-55");

        Book tehzeebulAkhlaq = new Book();
        tehzeebulAkhlaq.setTitle("TAHZEEBUL AKHLAQ");
        tehzeebulAkhlaq.setIsbn("1895-629");

        Book tefseerUlQuranSaved = bookRepository.save(tefseerUlQuran);
        Book aakiriMazameenSaved = bookRepository.save(aakiriMazameen);
        Book khutbatEAhmadiyaSaved = bookRepository.save(khutbatEAhmadiya);
        Book khutootESirSyedSaved = bookRepository.save(khutootESirSyed);
        Book lecturSaved = bookRepository.save(lectur);
        Book tehzeebulAkhlaqSaved = bookRepository.save(tehzeebulAkhlaq);

        sirSyedAhmadKhanSaved.getBooks().add(tefseerUlQuranSaved);
        sirSyedAhmadKhanSaved.getBooks().add(aakiriMazameenSaved);
        sirSyedAhmadKhanSaved.getBooks().add(khutbatEAhmadiyaSaved);
        sirSyedAhmadKhanSaved.getBooks().add(khutootESirSyedSaved);
        sirSyedAhmadKhanSaved.getBooks().add(lecturSaved);
        sirSyedAhmadKhanSaved.getBooks().add(tehzeebulAkhlaqSaved);
        /*Allama Iqbal */
        Author allamaIqbal = new Author();
        allamaIqbal.setFirstName("Muhammad ");
        allamaIqbal.setLastName("Allama Iqbal");

        Author allamaIqbalSaved = authorRepository.save(allamaIqbal);

        Book bangEDara = new Book();
        bangEDara.setTitle("BANG - E - DARA");
        bangEDara.setIsbn("1924-354");

        Book balEJibreel = new Book();
        balEJibreel.setTitle("BAL - E - JIBREEL");
        balEJibreel.setIsbn("1935-222");

        Book zarbEKaleem = new Book();
        zarbEKaleem.setTitle("ZARB - E - KALEEM");
        zarbEKaleem.setIsbn("1944-194");

        Book shikwaJawabEShiwkwa = new Book();
        shikwaJawabEShiwkwa.setTitle("SHIKWA JAWAB -E - SHIKWA");
        shikwaJawabEShiwkwa.setIsbn("0913-96");

        Book asrarEKhudi = new Book();
        asrarEKhudi.setTitle("ASRAR - E - KHUDI");
        asrarEKhudi.setIsbn("1976-87");

        Book asrorORamooz = new Book();
        asrorORamooz.setTitle("ASRAR - O - RAMOOZ");
        asrorORamooz.setIsbn("1966-203");

        Book khulliyatEIqbal = new Book();
        khulliyatEIqbal.setTitle("KULLIYAT - E - IQBAL");
        khulliyatEIqbal.setIsbn("1953-477");

        Book bangEDaraSaved = bookRepository.save(bangEDara);
        Book balEJibreelSaved = bookRepository.save(balEJibreel);
        Book zarbEKaleemSaved = bookRepository.save(zarbEKaleem);
        Book shikwaJawabEShiwkwaSaved = bookRepository.save(shikwaJawabEShiwkwa);
        Book asrarEKhudiSaved = bookRepository.save(asrarEKhudi);
        Book asrorORamoozSaved = bookRepository.save(asrorORamooz);
        Book khulliyatEIqbalSaved = bookRepository.save(khulliyatEIqbal);

        allamaIqbalSaved.getBooks().add(bangEDaraSaved);
        allamaIqbalSaved.getBooks().add(balEJibreelSaved);
        allamaIqbalSaved.getBooks().add(zarbEKaleemSaved);
        allamaIqbalSaved.getBooks().add(shikwaJawabEShiwkwaSaved);
        allamaIqbalSaved.getBooks().add(asrarEKhudiSaved);
        allamaIqbalSaved.getBooks().add(asrorORamoozSaved);
        allamaIqbalSaved.getBooks().add(khulliyatEIqbalSaved);



        //displaying data
        System.out.println("In BootStrap");
        System.out.println("Authors Count : "+authorRepository.count());
        System.out.println("Books Count : "+bookRepository.count());
    }

}
