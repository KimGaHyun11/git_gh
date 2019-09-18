//리스트 수만큼 rowspan 병합

$(document).ready(function () {
          $(".targetCell").each(function () {
              var rows = $(".targetCell:contains('" + $(this).text() + "')");
              if (rows.length > 1) {
                  rows.eq(0).attr("rowspan", rows.length);
                  rows.not(":eq(0)").remove(); 
              } 
          });
          
          $(".target").each(function () {
              var rows = $(".target:contains('" + $(this).text() + "')");
              if (rows.length > 1) {
                  rows.eq(0).attr("colspan", rows.length);
                  rows.not(":eq(0)").remove(); 
              } 
          });
      });
