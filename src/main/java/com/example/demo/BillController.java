package com.example.demo;

import com.example.demo.NextSequence.NextSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class BillController {
    public final NextSequenceService nextSequenceService;
    public final BillRepo billRepo;

    @Autowired
    public BillController( NextSequenceService nextSequenceService, BillRepo billRepo) {
        this.nextSequenceService = nextSequenceService;
        this.billRepo = billRepo;
    }
    @GetMapping("/bills")
    public ResponseEntity<List<Bill>> getAllBills(){
        List<Bill> bills = billRepo.findAll();
        return new ResponseEntity<>(bills,HttpStatus.OK);
    }

    @GetMapping("/bills/{id}")
    public ResponseEntity<?> getBillById(@PathVariable("id") String id){
        if(billRepo.existsById(id)){
            return ResponseEntity.ok().body(billRepo.findById(id));
        }
        else {
            return ResponseEntity.badRequest().body(new MessageResponse("Bill Not Found For Given Id..."));
        }
    }

    @GetMapping("/bills/due/{date}")
    public ResponseEntity<?> getAllByDate(@PathVariable("date") String date){
        if(billRepo.existsByBillDate(date)){
            return ResponseEntity.ok().body(billRepo.findAllByBillDate(date));
        }
        else {
            return ResponseEntity.badRequest().body(new MessageResponse("Bill Not Found For Given Date.."));
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Bill> add(@RequestBody Bill bill){
        bill.setBillNo(String.valueOf(nextSequenceService.getNextSequences("customSequences")));
        LocalDate localDate=LocalDate.now();
        bill.setBillDate(String.valueOf(localDate));
        bill.setBillTax((float) (bill.getBillAmount()*0.18));
        bill.setBillTotal(bill.getBillAmount()+ bill.getBillTax());
        Bill newBill=billRepo.save(bill);
        return new ResponseEntity<>(newBill,HttpStatus.OK);
    }

}
