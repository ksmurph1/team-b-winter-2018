/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java;

/**
 *
 * @author kerry
 */
interface ITicketDataLayer 
{
   Ticket[] getTickets();
   void saveTicket(final ImmutableTicket ticket);
}
