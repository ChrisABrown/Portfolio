import { Pet } from './Model'

export class MissingFieldError extends Error {}

export function validateAsPetEntry(arg: any) {
  if (!(arg as Pet).name) {
    throw new MissingFieldError('Value for name required!')
  }
  if (!(arg as Pet).sex) {
    throw new MissingFieldError('Value for sex required!')
  }
  if (!(arg as Pet).breed) {
    throw new MissingFieldError('Value for breed required!')
  }
}
