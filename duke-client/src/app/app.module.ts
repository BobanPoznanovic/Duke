import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule }    from '@angular/common/http';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AvailableAgentClassesComponent } from './available-agent-classes/available-agent-classes.component';
import { SendMessageComponent } from './send-message/send-message.component';
import { StartAgentComponent } from './start-agent/start-agent.component';
import { StopAgentComponent } from './stop-agent/stop-agent.component';

@NgModule({
  declarations: [
    AppComponent,
    AvailableAgentClassesComponent,
    SendMessageComponent,
    StartAgentComponent,
    StopAgentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
