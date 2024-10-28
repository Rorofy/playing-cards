import { Monster } from './../../models/monster.model';
import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-playing-card',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './playing-card.component.html',
  styleUrl: './playing-card.component.css',
})
export class PlayingCardComponent {
  @Input() monster: Monster = new Monster();
}
