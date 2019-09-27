import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AgentType } from './model/AgentType'
import { Observable } from 'rxjs';
import { AID } from './model/AID'

@Injectable({
  providedIn: 'root'
})
export class DukeRestService {

  private dukeRootURL = 'http://localhost:8080/duke-war/duke';
  private getAgentClassesURL = '/agents/classes';
  private getPerformativesURL = '/messages';
  private getRunningAgentsURL = '/agents/running';
  private startNewAgentURL = '/agents/running';
  private sendMessageURL = '/messages';
  private stopAgentURL = '/agents/running';

  private agentClasses : Observable<AgentType[]>;

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    private http: HttpClient
  ) { }

  getAgentClasses() {
    this.agentClasses = this.http.get<AgentType[]>(this.dukeRootURL + this.getAgentClassesURL);
    return this.agentClasses;
  }

  getRunningAgents() {
    console.log('Get running agents');
    return this.http.get<AID[]>(this.dukeRootURL + this.getRunningAgentsURL);
  }

  startAgent(type: AgentType, name: String) {
    return this.http.put<AID>(this.dukeRootURL + this.startNewAgentURL + '/' + name, type, this.httpOptions);
  }
}
