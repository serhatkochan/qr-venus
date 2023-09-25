package xtech.qrvenus.webApi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xtech.qrvenus.business.abstracts.QrCodePermissionService;
import xtech.qrvenus.business.requests.CreateQrCodePermissionRequest;
import xtech.qrvenus.business.requests.UpdateQrCodePermissionRequest;
import xtech.qrvenus.business.responses.GetAllQrCodePermissionsResponse;
import xtech.qrvenus.business.responses.GetByIdQrCodePermissionResponse;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/qr-code-permissions")
@AllArgsConstructor
@CrossOrigin
public class QrCodePermissionsController {
    private QrCodePermissionService qrCodePermissionService;

    @GetMapping
    public List<GetAllQrCodePermissionsResponse> getAll() {
        return qrCodePermissionService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdQrCodePermissionResponse getById(@PathVariable Integer id) {
        return qrCodePermissionService.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateQrCodePermissionRequest qrCodePermissionRequest) {
        qrCodePermissionService.add(qrCodePermissionRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateQrCodePermissionRequest updateQrCodePermissionRequest) {
        qrCodePermissionService.update(updateQrCodePermissionRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        qrCodePermissionService.delete(id);
    }
}
