package com.karakoc.starterproject.cv.pdf;

import com.karakoc.starterproject.cv.job.Job;
import com.karakoc.starterproject.cv.scheme.CVDto;
import com.karakoc.starterproject.cv.scheme.CVSchema;
import com.karakoc.starterproject.cv.scheme.CVService;
import com.karakoc.starterproject.cv.training.Training;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Locale;

@Service
@AllArgsConstructor
public class PDFGeneratorService {
    private final CVService service;
    public void export(HttpServletResponse response,String id) throws IOException {
        CVDto cv = service.getCVById(id);

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontHeader = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontHeader.setSize(22);
        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(14);
        Font fontTitles = FontFactory.getFont(FontFactory.TIMES);
        fontTitles.setSize(20);
        Font fontFields = FontFactory.getFont(FontFactory.TIMES);
        fontTitles.setSize(14);
        Paragraph ayirac = new Paragraph("----------------------------------------------", fontTitles);
        ayirac.setAlignment(Paragraph.ALIGN_LEFT);

        //WELCOME TEXT (1 line, name - surname)
        Paragraph headerParagraph = new Paragraph(cv.getFirstname().toUpperCase() +" "+ cv.getLastname().toUpperCase(), fontHeader);
        headerParagraph.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(headerParagraph);

        //USER INFORMATIONS (email, linkedin, phone)
        Paragraph user = new Paragraph("   Genel Bilgiler", fontHeader);
        headerParagraph.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(user);
        Paragraph email_linkedin_phonenumber = new Paragraph(cv.getEmail()  + " " + cv.getLinkedin() + " " + cv.getPhoneNumber(),fontParagraph);
        headerParagraph.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(email_linkedin_phonenumber);






        //TRAININGS
        int trainingsSize = cv.getTrainings().size();
        Paragraph trainings = new Paragraph("   Egitimler", fontHeader);
        trainings.setAlignment(Paragraph.ALIGN_MIDDLE);
        document.add(trainings);
        for (int i = 0;i<trainingsSize-1;i++){
            Training t = cv.getTrainings().get(i);
            Paragraph header = new Paragraph(t.getTitle(),fontTitles);
            document.add(header);
            Paragraph title = new Paragraph( t.getCompany() + "---" + t.getCity() + "---\n" + t.getDescription() + "\n\n", fontFields);
            title.setAlignment(Paragraph.ALIGN_LEFT);
            document.add(title);
            //title - bilgisayar muhendisligi lisansi

        }
        document.add(ayirac);


        int jobsSize = cv.getJobs().size();
        Paragraph jobs = new Paragraph("    Is Tecrubeleri", fontHeader);
        jobs.setAlignment(Paragraph.ALIGN_MIDDLE);
        document.add(jobs);

        for (int i = 0;i<jobsSize-1;i++){
            Job j = cv.getJobs().get(i);
            Paragraph header = new Paragraph(j.getTitle(),fontTitles);
            document.add(header);
            Paragraph title = new Paragraph( j.getCompany() + "---" + j.getCity() +"\n" + j.getDescription() + "\n\n", fontFields);
            title.setAlignment(Paragraph.ALIGN_LEFT);
            document.add(title);

        }
        document.add(ayirac);
        //is tecrubeleri bitti.



        Paragraph bottomInfos = new Paragraph(cv.getBottomInformation(),fontFields);
        bottomInfos.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(bottomInfos);
        document.close();
    }
}