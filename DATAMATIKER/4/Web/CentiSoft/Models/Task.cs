using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace CentisoftREST.Models
{
    public class Task
    {
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int Id { get; set; }
        public string Name { get; set; }
        public string Description { get; set; }
        public DateTime Created { get; set; }
        public float Duration { get; set; }
        public int ProjectId { get; set; } //foreign key to tasks
        [ForeignKey("ProjectId")]
        public Project Project { get; set; }
        public int DeveloperId { get; set; }
        [ForeignKey("DeveloperId")]
        public Developer Developer { get; set; }
    }
}