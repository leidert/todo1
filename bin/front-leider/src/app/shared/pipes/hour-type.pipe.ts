import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'hourType'
})
export class HourTypePipe implements PipeTransform {

  transform(hourType: string, args?: any): string {
    if (hourType === 'normalHour') {
      return 'Hora normal';
    } else if (hourType === 'sickDay') {
      return 'Incapacidad';
    } else if (hourType === 'extraHour') {
      return 'Hora extra';
    }else if (hourType === 'holidays') {
      return 'Vacaciones'; }
  }

}
