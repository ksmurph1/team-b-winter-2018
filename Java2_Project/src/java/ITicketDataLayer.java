/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kerry
 */
interface ITicketDataLayer 
{
   Ticket[] getTickets();
   void updateTicket(final ImmutableTicket ticket);

   Application getAppById(int id);

   Application[] loadApps();

}
