import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { DukeRestService} from '../duke-rest.service';
import { AgentType } from '../model/AgentType';

@Component({
  selector: 'app-start-agent',
  templateUrl: './start-agent.component.html',
  styleUrls: ['./start-agent.component.css']
})
export class StartAgentComponent implements OnInit {

  startAgentForm: FormGroup;
  private agentClasses: AgentType[];

  constructor(
    private formBuilder: FormBuilder,
    private dukeRestService: DukeRestService
  ) { }

  ngOnInit() {
    this.getAgentClassses();

    this.startAgentForm = this.formBuilder.group({
      name : new FormControl('', Validators.required),
      type : new FormControl('', Validators.required)
    });
  }

  onSubmit() {
    console.log('Start agent')
    console.log(this.startAgentForm.controls.name.value)
    console.log(this.startAgentForm.controls.type.value);

    this.dukeRestService.startAgent(this.startAgentForm.controls.type.value, this.startAgentForm.controls.name.value).subscribe(
      res => {
        console.log('Created agent: ' + res);
      }
    );
  }

  getAgentClassses() {
    this.dukeRestService.getAgentClasses().subscribe(
      res => {
        this.agentClasses = res;
      }
    );
  }
}
