import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { DukeRestService} from '../duke-rest.service';
import { AgentType } from '../model/AgentType';
import { AID } from '../model/AID';

@Component({
  selector: 'app-stop-agent',
  templateUrl: './stop-agent.component.html',
  styleUrls: ['./stop-agent.component.css']
})
export class StopAgentComponent implements OnInit {

  stopAgentForm: FormGroup;
  runningAgents: AID[];

  constructor(
    private formBuilder: FormBuilder,
    private dukeRestService: DukeRestService
  ) { }

  ngOnInit() {

    this.getRunningAgents();

    this.stopAgentForm = this.formBuilder.group({
      agent : new FormControl('', Validators.required)
    });
  }

  onSubmit() {
    console.log('Stop agent');
    console.log('Stopping: ' + this.stopAgentForm.controls.agent.value);
  }

  getRunningAgents() {
    this.dukeRestService.getRunningAgents().subscribe(
      res => {
        this.runningAgents = res;
      }
    );
  }

}
