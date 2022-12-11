package br.com.rpires.VisibilityAlgorithmTest.service;

import br.com.rpires.VisibilityAlgorithmTest.domain.Size;
import br.com.rpires.VisibilityAlgorithmTest.exception.InvalidFileException;
import br.com.rpires.VisibilityAlgorithmTest.factory.DomainFactory;
import br.com.rpires.VisibilityAlgorithmTest.helper.CSVHelper;
import br.com.rpires.VisibilityAlgorithmTest.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SizeService {

    private SizeRepository sizeRepository;

    private CSVHelper<Size> csvHelper;

    @Autowired
    public SizeService(SizeRepository sizeRepository,
                       @Qualifier("sizeFactory") DomainFactory<Size> domainFactory) {
        this.sizeRepository = sizeRepository;
        this.csvHelper = new CSVHelper(domainFactory);
    }

    public void upload(MultipartFile file) {
        Iterable<Size> it = readAndCreate(file);
        sizeRepository.saveAll(it);
    }

    private Iterable<Size> readAndCreate(MultipartFile file) {
        if (!csvHelper.hasCSVFormat(file)) {
            throw new InvalidFileException("INVALID FILE.", HttpStatus.BAD_REQUEST);
        }
        return csvHelper.readFile(file);
    }

    public Page<Size> findAll(Integer page, Integer size) {
        return sizeRepository.findAll(PageRequest.of(page, size));
    }
}
