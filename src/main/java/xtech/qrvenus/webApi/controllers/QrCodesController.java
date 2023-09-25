package xtech.qrvenus.webApi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xtech.qrvenus.business.abstracts.QrCodeService;
import xtech.qrvenus.business.requests.UpdateQrCodeRequest;
import xtech.qrvenus.business.responses.GetAllQrCodesResponse;
import xtech.qrvenus.business.responses.GetByCodeQrCodeResponse;
import xtech.qrvenus.business.responses.GetByUserIdQrCodesResponse;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/qr-codes")
@AllArgsConstructor
@CrossOrigin
public class QrCodesController {
    private QrCodeService qrCodeService;

    @GetMapping
    public List<GetAllQrCodesResponse> getAll() {
        return qrCodeService.getAll();
    }

    @GetMapping("/code/{code}")
    public GetByCodeQrCodeResponse getByCode(@PathVariable String code) {
        return qrCodeService.getByCode(code);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add() {
        qrCodeService.add();
    }

    @PutMapping
    public void update(@RequestBody UpdateQrCodeRequest updateQrCodeRequest) {
        qrCodeService.update(updateQrCodeRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        qrCodeService.delete(id);
    }

    @GetMapping("/user/{userId}")
    public List<GetByUserIdQrCodesResponse> getByUserId(@PathVariable Integer userId) {
        return qrCodeService.getByUserId(userId);
    }
}
