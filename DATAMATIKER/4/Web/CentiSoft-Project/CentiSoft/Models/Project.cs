using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace CentisoftREST.Models
{
    public class Project
    {
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int Id { get; set; }
        public string Name { get; set; }
        public DateTime DueDate { get; set; }
        public int CustomerId { get; set; }        
        [ForeignKey("CustomerId")]
        public Customer Customer { get; set; }
        [ForeignKey("ProjectId")]
        public List<Task> Tasks { get; set; }
    }
}