import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { DukeRestService} from '../duke-rest.service';
import { AID } from '../model/AID';

@Component({
  selector: 'app-send-message',
  templateUrl: './send-message.component.html',
  styleUrls: ['./send-message.component.css']
})
export class SendMessageComponent implements OnInit {

  sendMessageForm: FormGroup;
  runningAgents: AID[];

  constructor(
    private formBuilder: FormBuilder,
    private dukeRestService: DukeRestService
  ) { }

  ngOnInit() {
    this.getRunningAgents();

    this.sendMessageForm = this.formBuilder.group({
      sender: new FormControl(''),
      receiver: new FormControl()
    });

    this.onSubmit();
  }

  onSubmit() {
    console.log('Send message');
    console.log(this.sendMessageForm.controls.receiver.value);
    //receivers is array
  }

  getRunningAgents() {
    this.dukeRestService.getRunningAgents().subscribe(
      res => {
        this.runningAgents = res;
      }
    );
  }

}
