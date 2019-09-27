import { AID } from './AID'

export class ACLMessage {
    performative : Performative.Value;
    sender : AID;
    receivers : AID[];
    content : String;
}

module Performative {
    export enum Value {
        ACCEPT_PROPOSAL,
        AGREE, 
        CANCEL, 
        CALL_FOR_PROPOSAL, 
        CONFIRM, 
        DISCONFIRM, 
        FAILURE, 
        INFORM, 
        INFORM_IF, 
        INFORM_REF, 
        NOT_UNDERSTOOD, 
        PROPAGATE, 
        PROPOSE, 
        PROXY, 
        QUERY_IF, 
        QUERY_REF,
        REFUSE, 
        REJECT_PROPOSAL, 
        REQUEST, 
        REQUEST_WHEN, 
        REQUEST_WHENEVER, 
        SUBSCRIBE,
        RESUME
    }
}