import { Component, OnInit } from '@angular/core';
import { DukeRestService} from '../duke-rest.service';
import { Observable } from 'rxjs';
import { AgentType } from '../model/AgentType';

@Component({
  selector: 'app-available-agent-classes',
  templateUrl: './available-agent-classes.component.html',
  styleUrls: ['./available-agent-classes.component.css']
})
export class AvailableAgentClassesComponent implements OnInit {

  private agentClasses: AgentType[];

  constructor(
    private dukeRestService: DukeRestService
  ) { }

  ngOnInit() {
    this.getAgentClassses();
  }

  getAgentClassses() {
    this.dukeRestService.getAgentClasses().subscribe(
      res => {
        this.agentClasses = res;
      }
    );
  }

}
